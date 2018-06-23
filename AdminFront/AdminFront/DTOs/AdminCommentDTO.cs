using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.DTOs
{
    public class AdminCommentDTO
    {
        public long id { get; set; }
        public string comment { get; set; }
        public string agent { get; set; }

        public AdminCommentDTO()
        {

        }

        public AdminCommentDTO(long id, string comment, string agent)
        {
            this.id = id;
            this.comment = comment;
            this.agent = agent;
        }

    }
}
