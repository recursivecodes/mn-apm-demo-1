package codes.recursive;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class FavoriteNumber {
    private int favoriteNumber;

    public FavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }
}
