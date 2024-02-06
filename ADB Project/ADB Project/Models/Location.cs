using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WebAppADB.Models
{
    public class Location
    {
        public int LocationID { get; set; }
        public string Name { get; set; }
        public double CostRate { get; set; }
        public double Availability { get; set; }
        public DateTime ModifiedDate { get; set; }
    }
}
