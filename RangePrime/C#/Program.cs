using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RangePrime
{
    class Program
    {
        static void Main(string[] args)
        {
         
            
                int num1, num2, cheak = 0;
                Console.Write("Enter lower range: ");
                num1 = Convert.ToInt32(Console.ReadLine());
                Console.Write("Enter upper range: ");
                num2 = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("Prime numbers between {0} and {1} are: ", num1, num2);
                Console.WriteLine("==============================================");
                for (int i = num1; i < num2; i++)
                {
                    cheak = 0;
                    if (i > 1)
                    {
                        for (int j = 2; j < i; j++)
                        {
                            if (i % j == 0)
                            {
                                cheak = 1;
                                break;
                            }
                        }
                        if (cheak == 0)
                        {
                            Console.WriteLine(i);
                        }
                    }
                }
                Console.ReadKey();
            
        }
    }
}
