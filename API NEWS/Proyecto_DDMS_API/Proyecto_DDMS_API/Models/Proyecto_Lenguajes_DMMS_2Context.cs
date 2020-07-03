using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace Proyecto_DDMS_API.Models
{
    public partial class Proyecto_Lenguajes_DMMS_2Context : DbContext
    {
        public Proyecto_Lenguajes_DMMS_2Context()
        {
        }

        public Proyecto_Lenguajes_DMMS_2Context(DbContextOptions<Proyecto_Lenguajes_DMMS_2Context> options)
            : base(options)
        {
        }

        public virtual DbSet<Commentary> Commentary { get; set; }
        public virtual DbSet<Notice> Notice { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseSqlServer("Data Source=163.178.107.10;Initial Catalog=Proyecto_Lenguajes_DMMS_2;User ID=laboratorios;Password=Saucr.118");
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Commentary>(entity =>
            {
                entity.Property(e => e.CommentaryId).HasColumnName("Commentary_id");

                entity.Property(e => e.CommentaryString)
                    .IsRequired()
                    .HasColumnName("Commentary_String")
                    .HasMaxLength(200)
                    .IsUnicode(false);

                entity.Property(e => e.NoticeId).HasColumnName("Notice_id");

                entity.Property(e => e.PersonId).HasColumnName("Person_id");

                entity.HasOne(d => d.Notice)
                    .WithMany(p => p.Commentary)
                    .HasForeignKey(d => d.NoticeId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK__Commentar__Notic__35BCFE0A");
            });

            modelBuilder.Entity<Notice>(entity =>
            {
                entity.Property(e => e.NoticeId).HasColumnName("Notice_id");

                entity.Property(e => e.NoticeString)
                    .IsRequired()
                    .HasColumnName("Notice_String")
                    .HasMaxLength(200)
                    .IsUnicode(false);

                entity.Property(e => e.PersonId).HasColumnName("Person_id");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
