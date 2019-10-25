package com.example.infs3634assignment2.Model;

public class FoodDatabase {
    public static HashMap<Long, ID> foodID = new HashMap<>();

    public static FoodModel getfoodById(long foodID) {

        return FoodModel.getID();
    }

    /***
     * Return an ArrayList containing all the articles in the database.
     */
    public static ArrayList<FoodModel> getAllArticles() {
        return new ArrayList<Article>((List) Arrays.asList(articles.values().toArray()));
    }

    // This methods simulates saving the data you get from the API to your local database.
    // This way, we retrieve the whole object for an Article by using its ID.
    // Keep in mind it's not a real database yet.
    public static void saveArticlesToFakeDatabase(ArrayList<Article> articlesToSave) {
        for(int i = 0; i < articlesToSave.size(); i++) {
            Article article = articlesToSave.get(i);
            articles.put(article.getId(), article);
        }
    }


    // Following are methods that do the same but for books
    public static Book getBookByIsbn(long isbn) {
        return books.get(isbn);
    }

    public static void saveBooksToFakeDatabase(ArrayList<Book> booksToSave) {
        for(int i = 0; i < booksToSave.size(); i++) {
            Book book = booksToSave.get(i);
            books.put(book.getIsbn(), book);
        }
        System.out.println(books);
    }


}
