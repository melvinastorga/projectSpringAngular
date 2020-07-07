using System;
using System.Collections.Generic;

namespace Proyecto_DDMS_API.Models
{
    public partial class Notice
    {
        public Notice()
        {
            Commentary = new HashSet<Commentary>();
        }

        public int NoticeId { get; set; }
        public int PersonId { get; set; }
        public string NoticeString { get; set; }

        public string PersonName { get; set; }

        public string PersonLastName { get; set; }

        public virtual ICollection<Commentary> Commentary { get; set; }
    }
}
