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
    public class CommentaryController : ControllerBase
    {
        Proyecto_Lenguajes_DMMS_2Context _context = new Proyecto_Lenguajes_DMMS_2Context();




        [EnableCors("GetAllPolicy")]
        [Route("[action]/{id}")]
        [HttpGet]
        public IActionResult GetCommentariesByNotice(int id)
        {

            var noticeId = new SqlParameter("@Notice_id", id);
            var comentaries = _context.Commentary
                                .FromSqlRaw($"SelectCommentaryByNotice @Notice_id", noticeId)
                                .AsEnumerable();
            if (comentaries == null)
            {
                return NotFound();
            }
            return Ok(comentaries);
        }

        // POST: api/Commentary
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpPost]
        public IActionResult PostCommentary(Commentary commentary)
        {
            var result = _context.Database.ExecuteSqlRaw("InsertUpdateCommentary  {0}, {1}, {2}, {3}, {4}",
                                    commentary.CommentaryId,
                                    commentary.PersonId,
                                    commentary.NoticeId,
                                    commentary.CommentaryString,
                                    "Insert");
            if (result == 0)
            {
                return null;
            }

            return Ok(result);
        }

    }

}
