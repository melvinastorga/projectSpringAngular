1.Correr el proyecto de spring  llamado examen 
2.dirigirse a al postman para probar el crud
3.para listar lis registros utilice el metodo get con la siguiente url

http://localhost:8080/api/major/getMajors

4.Para traer solo un dato utilice el metodo get con la siguiente url 
http://localhost:8080/api/major/getMajor/{id}(es el id sin las llaves)

5.Para eliminar el registro utilice el metodo delite
http://localhost:8080/api/major/delete/{id}(es el id sin las llaves)

6.Utilice el mertodo post para crear un nuevo registro con la siguiente url 

http://localhost:8080/api/major/postMajor
 y el siguiente curpo en formato json

{
    "major": "",
    "semesters": 10
}


6.Utilice el mertodo post para actualizar registro con la siguiente url 

http://localhost:8080/api/major/postMajor
 y el siguiente curpo en formato json

{
    "major_id": 10,
    "major": "",
    "semesters": 10
}