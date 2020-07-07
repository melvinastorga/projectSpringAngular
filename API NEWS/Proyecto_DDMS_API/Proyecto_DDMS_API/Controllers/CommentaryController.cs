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

        // GET: api/Commentary
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Commentary>>> GetCommentary()
        {
            return await _context.Commentary.ToListAsync();
        }

        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public IEnumerable<Commentary> GetAllCommentaries()
        {
            try
            {
                return _context.Commentary.ToList();
            }
            catch
            {
                throw;
            }
        }

        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpGet]
        public IActionResult GetAllCommentariesSP()
        {
            var comentaries = _context.Commentary
                                .FromSqlRaw($"SelectCommentary")
                                .AsEnumerable();
            return Ok(comentaries);
        }



        // GET: api/Commentary/5
        [EnableCors("GetAllPolicy")]
        [Route("[action]/{id}")]
        [HttpGet]
        public IActionResult GetCommentary(int id)
        {
            var commentaryId = new SqlParameter("@Commentary_id", id);
            var commentary = _context.Commentary
                            .FromSqlRaw($"SelectCommentaryById @Commentary_id", commentaryId)
                            .AsEnumerable().Single();

            if (commentary == null)
            {
                return NotFound();
            }
            return Ok(commentary);
        }

        // PUT: api/Commentary/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for
        // more details see https://aka.ms/RazorPagesCRUD.
        [EnableCors("GetAllPolicy")]
        [Route("[action]")]
        [HttpPut]
        public IActionResult PutCommentary(Commentary commentary)
        {
            var result = _context.Database.ExecuteSqlRaw("InsertUpdateCommentary {0}, {1}, {2}, {3}, {4}",
                                    commentary.CommentaryId,
                                    commentary.PersonId,
                                    commentary.NoticeId,
                                    commentary.CommentaryString,
                                    "Update");
            if (result == 0)
            {
                return null;
            }

            return Ok(result);
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

        // DELETE: api/Commentary/5
        [EnableCors("GetAllPolicy")]
        [Route("[action]/{id}")]
        [HttpDelete]
        public IActionResult DeleteCommentary(int id)
        {
            var result = _context.Database.ExecuteSqlRaw("DeleteCommentary {0}", id);
            if (result == 0)
            {
                return null;
            }
            return Ok(result);
        }

        private bool CommentaryExists(int id)
        {
            return _context.Commentary.Any(e => e.CommentaryId == id);
        }
    }
}
