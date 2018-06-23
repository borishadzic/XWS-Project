using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class FilterDTO
    {
        public List<AccomodationTypeDTO> types { get; set; }
        public List<CategoryDTO> categories { get; set; }
        public List<AdditionalServicesDTO> services { get; set; }

        public FilterDTO()
        {

        }

        public FilterDTO(List<AccomodationTypeDTO> types, List<CategoryDTO> categories, List<AdditionalServicesDTO> services)
        {
            this.types = types;
            this.categories = categories;
            this.services = services;
        }

    }
}
