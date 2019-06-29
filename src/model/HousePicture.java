package model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "house_picture", schema = "tenement", catalog = "")
public class HousePicture {
    private int pictureId;
    private int houseId;
    private byte[] picture;

    @Id
    @Column(name = "picture_id")
    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    @Basic
    @Column(name = "house_id")
    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HousePicture that = (HousePicture) o;
        return pictureId == that.pictureId &&
                houseId == that.houseId &&
                Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(pictureId, houseId);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
