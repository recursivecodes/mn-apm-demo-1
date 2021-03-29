package codes.recursive;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client("${codes.recursive.demo2.baseUrl}")
public interface Demo2Client {
    @Get ("/demo2/favoriteNumber/{id}")
    Flowable<FavoriteNumber> favoriteNumber(int id);
}