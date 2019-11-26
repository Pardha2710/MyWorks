using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;


namespace TrainDataClient
{
    class Program
    {
        static HttpClient client = new HttpClient();
        static void Main(string[] args)
        {
            RunAsync().GetAwaiter().GetResult();
        }
        static async Task RunAsync()
        {
            client.BaseAddress = new Uri("https://localhost:44370");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));

            try
            {
                string json;
                HttpResponseMessage response;

                //get all items
                response = await client.GetAsync("/api/gettrains");

                if (response.IsSuccessStatusCode)
                {
                    json = await response.Content.ReadAsStringAsync();

                    IEnumerable<TrainData> items = JsonConvert.DeserializeObject<IEnumerable<TrainData>>(json);
                    foreach (TrainData item in items)
                    {
                        Console.WriteLine("Train Numbers:" + item.TrainNumber);
                        Console.WriteLine("Train Names:" + item.TrainName);
                    }
                }
                else
                {
                    Console.WriteLine("Internal Server error");
                    Console.WriteLine("Please enter the number of the train you want to delete : ");
                    int deleteId = Convert.ToInt32(Console.ReadLine());
                    response = await client.DeleteAsync("/delete/" + deleteId);
                    Console.WriteLine($"status from DELETE {response.StatusCode}");
                    response.EnsureSuccessStatusCode();
                }
                }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            Console.ReadLine();
        }
    }
}