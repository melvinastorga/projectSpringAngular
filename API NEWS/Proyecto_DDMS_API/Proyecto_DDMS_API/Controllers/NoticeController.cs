using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore;
using Proyecto_DDMS_API.Models;

namespace Proyecto_DDMS_API.Controllers
{
    [Route("api/[controller]")]
    [AllowAnonymous]
    [ApiController]
    public class NoticeController : ControllerBase
    {
        Proyecto_Lenguajes_DMMS_2Context _context = new Proyecto_Lenguajes_DMMS_2Context();


        // GET: api/Notice  ya
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Notice>>> GetNotice()
        {
            return await _context.Notice.ToListAsync();
        }

        //Ya
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public IEnumerable<Notice> GetAllNotices()
        {
            try
            {
                return _context.Notice.ToList();
            }
            catch
            {
                throw;
            }
        }

        //ya
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public IActionResult GetAllNoticesSP()
        {
            var notices = _context.Notice
                            .FromSqlRaw($"SelectNotice")
                            .AsEnumerable();
            return Ok(notices);
        }

        // GET: api/Notice/5  Ya
        [EnableCors("GetAllPolicy")]
        [Route("[action]/{id}")]
        [HttpGet]
        public IActionResult GetNotice(int id)
        {
            var noticeId = new SqlParameter("@Notice_id", id);
            var notice = _context.Notice
                            .FromSqlRaw($"SelectNoticeById @Notice_id", noticeId)
                            .AsEnumerable().Single();

            if (notice == null)
            {
                return NotFound();
            }

            return Ok(notice);
        }

        // PUT: api/Notice/5  Ya
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpPut]
        public IActionResult PutNotice(Notice notice)
        {
            var result = _context.Database.ExecuteSqlRaw("InsertUpdateNotice {0}, {1}, {2}, {3}, {4}",
                                 notice.NoticeId,
                                 notice.PersonId,
                                 notice.NoticeString,
                                 notice.Title,
                                 "Update");

            if (result == 0)
            {
                return null;
            }

            return Ok(result);
        }

        // POST: api/Notice  Ya
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpPost]
        public IActionResult PostNotice(Notice notice)
        {
            var result = _context.Database.ExecuteSqlRaw("InsertUpdateNotice {0}, {1}, {2}, {3}, {4}",
                                notice.NoticeId,
                                notice.PersonId,
                                notice.NoticeString,
                                notice.Title,
                                "Insert");

            if (result == 0)
            {
                return null;
            }

            return Ok(result);

        }

        // DELETE: api/Notice/5  ya
        [EnableCors("GetAllPolicy")]
        [Route("[action]/{id}")]
        [HttpDelete]
        public IActionResult DeleteNotice(int id)
        {
            var result = _context.Database.ExecuteSqlRaw("DeleteNotice {0}", id);

            if (result == 0)
            {
                return null;
            }
            return Ok(result);
        }

        private bool NoticeExists(int id)
        {
            return _context.Notice.Any(e => e.NoticeId == id);
        }
    }
}
