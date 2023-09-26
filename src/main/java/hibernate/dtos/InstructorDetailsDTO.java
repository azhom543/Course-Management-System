package hibernate.dtos;

import jakarta.persistence.Column;

import java.util.UUID;

public class InstructorDetailsDTO {
    private UUID id;
    private String youtubeChannel;
    private String hobbies;

    public InstructorDetailsDTO() {
    }

    public InstructorDetailsDTO(UUID id, String youtubeChannel, String hobbies) {
        this.id = id;
        this.youtubeChannel = youtubeChannel;
        this.hobbies = hobbies;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }
}
