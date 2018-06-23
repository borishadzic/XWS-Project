using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.Requests
{
    public class Login
    {
        public string email { get; set; }
        public string password { get; set; }

        public Login()
        {

        }
        public Login(string email, string password)
        {
            this.email = email;
            this.password = password;
        }


    }
}
