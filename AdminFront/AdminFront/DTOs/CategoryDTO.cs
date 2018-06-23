using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class CategoryDTO
    {
        public string category { get; set; }
        public long id { get; set; }
        public CategoryDTO()
        {

        }
        public CategoryDTO(string category, long id)
        {
            this.category = category;
            this.id = id;
        }
    }
}
