using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class ModifyDTO
    {
        public string oldName { get; set; }
        public string newName { get; set; }
        public ModifyDTO() { }
        public ModifyDTO(string oldName, string newName) { this.oldName = oldName; this.newName = newName; }
    }
}
