package Person.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DatabaseConfig;
import Person.domain.entity.Person;
import Person.domain.service.PersonService;

public class PersonRepository implements PersonService{

    @Override
    public void createPerson(Person person) {
        String sql = "INSERT INTO Person (id, name, lastname, idCity, address, age, email, idGender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getLastname());
            statement.setInt(4, person.getIdCity());
            statement.setString(5, person.getAddress());
            statement.setInt(6, person.getAge());
            statement.setString(7, person.getEmail());
            statement.setInt(8, person.getIdGender());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void updatePerson(Person person) {
        String sql = "UPDATE Person SET name = ?, lastname = ?, idCity = ?, address = ?, age = ?, email = ?, idGender = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, person.getName());
            statement.setString(2, person.getLastname());
            statement.setInt(3, person.getIdCity());
            statement.setString(4, person.getAddress());
            statement.setInt(5, person.getAge());
            statement.setString(6, person.getEmail());
            statement.setInt(7, person.getIdGender());
            statement.setInt(8, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void deletePerson(int id) {
        String sql = "DELETE FROM Person WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Person readPerson(int id) {
         String sql = "SELECT * FROM Person WHERE id = ?";
        Person person = null;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setLastname(rs.getString("lastname"));
                    person.setIdCity(rs.getInt("idCity"));
                    person.setAddress(rs.getString("address"));
                    person.setAge(rs.getInt("age"));
                    person.setEmail(rs.getString("email"));
                    person.setIdGender(rs.getInt("idGender"));
                }
            }
        } catch (SQLException e) {
        }

        return person;
    }

    @Override
    public boolean existById(int id) {
        String sql = "SELECT COUNT(*) FROM Person WHERE id = ?";
        boolean exists = false;

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    exists = rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
        }

        return exists;
    }

    @Override
    public Person findById(int id) {
        return readPerson(id);
    }

}
