using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class LoginToken
    {
        public class profile
        {
            public string username { get; set; }
            public List<string> authorities { get; set; }
            
        }
        public string accessToken { get; set; }
    
        

        
    }
}
