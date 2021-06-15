package mx.edu.utez.CRUD.model;

import mx.edu.utez.CRUD.util.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoPerson {

    Logger logger = LoggerFactory.getLogger(DaoPerson.class);
    public boolean save(Person person){
        try(Connection con = ConnectionMySQL.getConnection();){
            try(
                    PreparedStatement pstm =
                            con.prepareStatement("insert into person (nombre, edad) values (?,?)")
            ){
                pstm.setString(1,person.getNombre());
                pstm.setInt(2,person.getEdad());
                return pstm.executeUpdate()==1;
            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return false;
    }

    public List<Person> findAll() {
        List<Person> listPerson = new ArrayList<>();
        try(
                Connection con = ConnectionMySQL.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery("select * from person");
                ){
            while (rs.next()){
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setNombre(rs.getString("nombre"));
                person.setEdad(rs.getInt("edad"));
                listPerson.add(person);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return listPerson;
    }

    public Person finbById(int id) {
        Person person = new Person();
        try(
                Connection con = ConnectionMySQL.getConnection();
                PreparedStatement stm = con.prepareStatement("select * from person where id = ?");
        ){
            stm.setInt(1,id);
            try(ResultSet rs = stm.executeQuery();) {

                while (rs.next()) {
                    person.setId(rs.getInt("id"));
                    person.setNombre(rs.getString("nombre"));
                    person.setEdad(rs.getInt("edad"));
                }

            }catch (Exception e){
                logger.error(e.getMessage());
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return person;
    }
}
