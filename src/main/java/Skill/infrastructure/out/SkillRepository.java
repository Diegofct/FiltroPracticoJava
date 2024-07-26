package Skill.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DatabaseConfig;
import Skill.domain.entity.Skill;
import Skill.domain.service.SkillService;

public class SkillRepository implements SkillService{

    @Override
    public void createSkill(Skill skill) {
        String sql = "INSERT INTO Skill (id, name) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
                statement.setInt(1, skill.getId());
                statement.setString(2, skill.getName());
                statement.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean existById(int id) {
        String sql = "SELECT COUNT(*) FROM Skill WHERE id = ?";
        boolean exists = false;

        try (Connection conn = DatabaseConfig.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql)){
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
    
}
