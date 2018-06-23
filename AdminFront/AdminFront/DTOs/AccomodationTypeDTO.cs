using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class AccomodationTypeDTO
    {

        public string type { get; set; }
        public long id { get; set; }
        public AccomodationTypeDTO()
        {

        }

        public AccomodationTypeDTO(string type, long id)
        {
            this.type = type;
            this.id = id;
        }
    }
}
