package com.yuliayakupova.mood.repo;

import com.yuliayakupova.mood.dto.Mood;
import com.yuliayakupova.mood.dto.MoodType;
import com.yuliayakupova.mood.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class MoodRepository {
    private final static String INSERT_MOOD_DATA = """
             INSERT INTO Mood (
            user_id,
            mood_type_id,
            mood_value,
            mood_timestamp
         ) VALUES (
            ?,
            ?,
            ?,
            datetime()
         )
        """;

    private final static String SELECT_ALL_MOOD = "SELECT " +
            "m.mood_value, m.mood_timestamp, u.user_login, mt.mood_name " +
            "FROM Mood m " +
            "JOIN User u ON " +
            "m.user_id = u.id " +
            "JOIN MoodType mt " +
            "ON m.mood_type_id = mt.id";

    @Autowired
    private final JdbcTemplate connection;

    public MoodRepository(JdbcTemplate connection) {
        this.connection = connection;
    }

    public void saveMoodData(Mood mood, User user, MoodType moodType){
        try{
            connection.update(INSERT_MOOD_DATA,
                    user.getId(),
                    moodType.getMoodName(),
                    mood.getMoodValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Mood> getAllMood() {
        return connection.query(SELECT_ALL_MOOD, (resultSet, rowNum) -> {
            Mood mood = new Mood();
            User user = new User();
            MoodType moodType = new MoodType();

            user.setLogin(resultSet.getString("user_login"));
            moodType.setMoodName(resultSet.getString("mood_name"));
            mood.setMoodValue(resultSet.getString("mood_value"));

            Timestamp timestamp = resultSet.getTimestamp("mood_timestamp");
            LocalDateTime moodTimestamp = timestamp.toLocalDateTime();

            mood.setMoodTimestamp(moodTimestamp);
            mood.setUser(user);
            mood.setMoodType(moodType);

            return mood;
        });
    }

    public MoodType findMoodTypeByMoodName(String moodName) {
        String query = "SELECT * FROM MoodType WHERE moodName = ?";
        return connection.queryForObject(query, new Object[]{moodName}, (resultSet, rowNum) -> {
            MoodType moodType = new MoodType();
            moodType.setId(resultSet.getInt("id"));
            moodType.setMoodName(resultSet.getString("moodName"));
            return moodType;
        });
    }
}
