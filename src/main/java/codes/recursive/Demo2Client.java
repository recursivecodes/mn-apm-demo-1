package codes.recursive;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Flowable;

@Client("http://demo2.toddrsharp.com:8080")
public interface Demo2Client {
    @Get ("/demo2/favoriteNumber/{id}")
    Flowable<FavoriteNumber> favoriteNumber(int id);
}