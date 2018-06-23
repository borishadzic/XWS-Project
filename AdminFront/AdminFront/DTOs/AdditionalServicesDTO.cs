using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class AdditionalServicesDTO
    {
        public string name { get; set; }
        public long id { get; set; }
        public AdditionalServicesDTO()
        {

        }

        public AdditionalServicesDTO(string name, long id)
        {
            this.name = name;
            this.id = id;
        }

    }
}
