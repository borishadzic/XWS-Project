using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class ProfileDTO
    {
        public String username { get;set; }

        public List<String> authorities { get; set; }

        public bool nonLocked { get; set; }

        public ProfileDTO(String username, List<String> authorities, bool nonLocked)
        {
            this.username = username;
            this.authorities = authorities;
            this.nonLocked = nonLocked;
        }

        

        public override string ToString()
        {
            return this.username ;
        }

    }
}
