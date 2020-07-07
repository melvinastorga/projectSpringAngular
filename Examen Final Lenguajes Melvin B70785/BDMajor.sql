CREATE TABLE Major(
major_id INT IDENTITY primary key,
major_name NVARCHAR(50),
major_description NVARCHAR(100),
semesters INT
)

INSERT INTO Major values('Informática Empresarial','Curso para aprender sobre tecnologías de información y administración',8);
INSERT INTO Major values('Turismo ecológico','Curso para aprender sobre el cuidado del medio ambiente',8);
INSERT INTO Major values('a','b',8);


--Stored Procedure


Create Procedure getAllMajors
as begin 

select * from Major

end

Create Procedure [dbo].[get_Major_By_Id] (@Major_id int)
as begin 

select * from Major where major_id = @Major_id 

end


Create procedure delete_Major (@Major_id int)
as begin 

Delete from Major where major_id = @Major_id

end
select * from major

Create Procedure insertMajor (@Major_name NVARCHAR(50), @Major_description NVARCHAR(100), @Semesters int)
as begin
insert into Major values(@Major_name, @Major_description, @Semesters)
end

Create Procedure updateMajor (@Major_id int, @Major_name NVARCHAR(50), @Major_description NVARCHAR(100), @Semesters int)
as begin
Update Major set major_name = @Major_name, major_description = @Major_description, semesters = @Semesters
where major_id = @Major_id
end


Create Procedure [dbo].[getLastId]
as begin
declare @lastId int
select @lastId = MAX(major_id) from Major
select *  from Major where major_id = @lastId
end
