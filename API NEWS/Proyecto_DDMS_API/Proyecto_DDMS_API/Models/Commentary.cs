using System;
using System.Collections.Generic;

namespace Proyecto_DDMS_API.Models
{
    public partial class Commentary
    {
        public int CommentaryId { get; set; }
        public int PersonId { get; set; }
        public int NoticeId { get; set; }
        public string CommentaryString { get; set; }

        public string PersonName { get; set; }

        public string PersonLastName { get; set; }

        public virtual Notice Notice { get; set; }
    }
}
