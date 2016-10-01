package com.ihorizons.marvelapp.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed on 01/10/16.
 */
public class SeriesResponse extends DetailsResponse {

        private Integer code;
        private String status;
        private String copyright;
        private String attributionText;
        private String attributionHTML;
        private String etag;
        private Data data;

        /**
         *
         * @return
         * The code
         */
        public Integer getCode() {
            return code;
        }

        /**
         *
         * @param code
         * The code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         *
         * @return
         * The status
         */
        public String getStatus() {
            return status;
        }

        /**
         *
         * @param status
         * The status
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         *
         * @return
         * The copyright
         */
        public String getCopyright() {
            return copyright;
        }

        /**
         *
         * @param copyright
         * The copyright
         */
        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        /**
         *
         * @return
         * The attributionText
         */
        public String getAttributionText() {
            return attributionText;
        }

        /**
         *
         * @param attributionText
         * The attributionText
         */
        public void setAttributionText(String attributionText) {
            this.attributionText = attributionText;
        }

        /**
         *
         * @return
         * The attributionHTML
         */
        public String getAttributionHTML() {
            return attributionHTML;
        }

        /**
         *
         * @param attributionHTML
         * The attributionHTML
         */
        public void setAttributionHTML(String attributionHTML) {
            this.attributionHTML = attributionHTML;
        }

        /**
         *
         * @return
         * The etag
         */
        public String getEtag() {
            return etag;
        }

        /**
         *
         * @param etag
         * The etag
         */
        public void setEtag(String etag) {
            this.etag = etag;
        }

        /**
         *
         * @return
         * The data
         */
        public Data getData() {
            return data;
        }

        /**
         *
         * @param data
         * The data
         */
        public void setData(Data data) {
            this.data = data;
        }





    public class Stories {

        private Integer available;
        private String collectionURI;
        private List<Item__> items = new ArrayList<Item__>();
        private Integer returned;

        /**
         *
         * @return
         * The available
         */
        public Integer getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(Integer available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The collectionURI
         */
        public String getCollectionURI() {
            return collectionURI;
        }

        /**
         *
         * @param collectionURI
         * The collectionURI
         */
        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        /**
         *
         * @return
         * The items
         */
        public List<Item__> getItems() {
            return items;
        }

        /**
         *
         * @param items
         * The items
         */
        public void setItems(List<Item__> items) {
            this.items = items;
        }

        /**
         *
         * @return
         * The returned
         */
        public Integer getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(Integer returned) {
            this.returned = returned;
        }



    }


    public class Characters {

        private Integer available;
        private String collectionURI;
        private List<Item_> items = new ArrayList<Item_>();
        private Integer returned;

        /**
         *
         * @return
         * The available
         */
        public Integer getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(Integer available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The collectionURI
         */
        public String getCollectionURI() {
            return collectionURI;
        }

        /**
         *
         * @param collectionURI
         * The collectionURI
         */
        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        /**
         *
         * @return
         * The items
         */
        public List<Item_> getItems() {
            return items;
        }

        /**
         *
         * @param items
         * The items
         */
        public void setItems(List<Item_> items) {
            this.items = items;
        }

        /**
         *
         * @return
         * The returned
         */
        public Integer getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(Integer returned) {
            this.returned = returned;
        }



    }

    public class Comics {

        private Integer available;
        private String collectionURI;
        private List<Item___> items = new ArrayList<Item___>();
        private Integer returned;

        /**
         *
         * @return
         * The available
         */
        public Integer getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(Integer available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The collectionURI
         */
        public String getCollectionURI() {
            return collectionURI;
        }

        /**
         *
         * @param collectionURI
         * The collectionURI
         */
        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        /**
         *
         * @return
         * The items
         */
        public List<Item___> getItems() {
            return items;
        }

        /**
         *
         * @param items
         * The items
         */
        public void setItems(List<Item___> items) {
            this.items = items;
        }

        /**
         *
         * @return
         * The returned
         */
        public Integer getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(Integer returned) {
            this.returned = returned;
        }



    }

    public class Creators {

        private Integer available;
        private String collectionURI;
        private List<Item> items = new ArrayList<Item>();
        private Integer returned;

        /**
         *
         * @return
         * The available
         */
        public Integer getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(Integer available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The collectionURI
         */
        public String getCollectionURI() {
            return collectionURI;
        }

        /**
         *
         * @param collectionURI
         * The collectionURI
         */
        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        /**
         *
         * @return
         * The items
         */
        public List<Item> getItems() {
            return items;
        }

        /**
         *
         * @param items
         * The items
         */
        public void setItems(List<Item> items) {
            this.items = items;
        }

        /**
         *
         * @return
         * The returned
         */
        public Integer getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(Integer returned) {
            this.returned = returned;
        }



    }

    public class Data {

        private Integer offset;
        private Integer limit;
        private Integer total;
        private Integer count;
        private List<Result> results = new ArrayList<Result>();

        /**
         *
         * @return
         * The offset
         */
        public Integer getOffset() {
            return offset;
        }

        /**
         *
         * @param offset
         * The offset
         */
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        /**
         *
         * @return
         * The limit
         */
        public Integer getLimit() {
            return limit;
        }

        /**
         *
         * @param limit
         * The limit
         */
        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        /**
         *
         * @return
         * The total
         */
        public Integer getTotal() {
            return total;
        }

        /**
         *
         * @param total
         * The total
         */
        public void setTotal(Integer total) {
            this.total = total;
        }

        /**
         *
         * @return
         * The count
         */
        public Integer getCount() {
            return count;
        }

        /**
         *
         * @param count
         * The count
         */
        public void setCount(Integer count) {
            this.count = count;
        }

        /**
         *
         * @return
         * The results
         */
        public List<Result> getResults() {
            return results;
        }

        /**
         *
         * @param results
         * The results
         */
        public void setResults(List<Result> results) {
            this.results = results;
        }


    }

    public class Events {

        private Integer available;
        private String collectionURI;
        private List<Object> items = new ArrayList<Object>();
        private Integer returned;

        /**
         *
         * @return
         * The available
         */
        public Integer getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(Integer available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The collectionURI
         */
        public String getCollectionURI() {
            return collectionURI;
        }

        /**
         *
         * @param collectionURI
         * The collectionURI
         */
        public void setCollectionURI(String collectionURI) {
            this.collectionURI = collectionURI;
        }

        /**
         *
         * @return
         * The items
         */
        public List<Object> getItems() {
            return items;
        }

        /**
         *
         * @param items
         * The items
         */
        public void setItems(List<Object> items) {
            this.items = items;
        }

        /**
         *
         * @return
         * The returned
         */
        public Integer getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(Integer returned) {
            this.returned = returned;
        }



    }

    public class Item {

        private String resourceURI;
        private String name;
        private String role;

        /**
         *
         * @return
         * The resourceURI
         */
        public String getResourceURI() {
            return resourceURI;
        }

        /**
         *
         * @param resourceURI
         * The resourceURI
         */
        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The role
         */
        public String getRole() {
            return role;
        }

        /**
         *
         * @param role
         * The role
         */
        public void setRole(String role) {
            this.role = role;
        }



    }

    public class Item_ {

        private String resourceURI;
        private String name;

        /**
         *
         * @return
         * The resourceURI
         */
        public String getResourceURI() {
            return resourceURI;
        }

        /**
         *
         * @param resourceURI
         * The resourceURI
         */
        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }



    }

    public class Item__ {

        private String resourceURI;
        private String name;
        private String type;

        /**
         *
         * @return
         * The resourceURI
         */
        public String getResourceURI() {
            return resourceURI;
        }

        /**
         *
         * @param resourceURI
         * The resourceURI
         */
        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The type
         */
        public String getType() {
            return type;
        }

        /**
         *
         * @param type
         * The type
         */
        public void setType(String type) {
            this.type = type;
        }



    }

    public class Item___ {

        private String resourceURI;
        private String name;

        /**
         *
         * @return
         * The resourceURI
         */
        public String getResourceURI() {
            return resourceURI;
        }

        /**
         *
         * @param resourceURI
         * The resourceURI
         */
        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }



    }

    public class Result {

        private Integer id;
        private String title;
        private Object description;
        private String resourceURI;
        private List<Url> urls = new ArrayList<Url>();
        private Integer startYear;
        private Integer endYear;
        private String rating;
        private String type;
        private String modified;
        private Thumbnail thumbnail;
        private Creators creators;
        private Characters characters;
        private Stories stories;
        private Comics comics;
        private Events events;
        private Object next;
        private Object previous;

        /**
         *
         * @return
         * The id
         */
        public Integer getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The description
         */
        public Object getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(Object description) {
            this.description = description;
        }

        /**
         *
         * @return
         * The resourceURI
         */
        public String getResourceURI() {
            return resourceURI;
        }

        /**
         *
         * @param resourceURI
         * The resourceURI
         */
        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        /**
         *
         * @return
         * The urls
         */
        public List<Url> getUrls() {
            return urls;
        }

        /**
         *
         * @param urls
         * The urls
         */
        public void setUrls(List<Url> urls) {
            this.urls = urls;
        }

        /**
         *
         * @return
         * The startYear
         */
        public Integer getStartYear() {
            return startYear;
        }

        /**
         *
         * @param startYear
         * The startYear
         */
        public void setStartYear(Integer startYear) {
            this.startYear = startYear;
        }

        /**
         *
         * @return
         * The endYear
         */
        public Integer getEndYear() {
            return endYear;
        }

        /**
         *
         * @param endYear
         * The endYear
         */
        public void setEndYear(Integer endYear) {
            this.endYear = endYear;
        }

        /**
         *
         * @return
         * The rating
         */
        public String getRating() {
            return rating;
        }

        /**
         *
         * @param rating
         * The rating
         */
        public void setRating(String rating) {
            this.rating = rating;
        }

        /**
         *
         * @return
         * The type
         */
        public String getType() {
            return type;
        }

        /**
         *
         * @param type
         * The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         *
         * @return
         * The modified
         */
        public String getModified() {
            return modified;
        }

        /**
         *
         * @param modified
         * The modified
         */
        public void setModified(String modified) {
            this.modified = modified;
        }

        /**
         *
         * @return
         * The thumbnail
         */
        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        /**
         *
         * @param thumbnail
         * The thumbnail
         */
        public void setThumbnail(Thumbnail thumbnail) {
            this.thumbnail = thumbnail;
        }

        /**
         *
         * @return
         * The creators
         */
        public Creators getCreators() {
            return creators;
        }

        /**
         *
         * @param creators
         * The creators
         */
        public void setCreators(Creators creators) {
            this.creators = creators;
        }

        /**
         *
         * @return
         * The characters
         */
        public Characters getCharacters() {
            return characters;
        }

        /**
         *
         * @param characters
         * The characters
         */
        public void setCharacters(Characters characters) {
            this.characters = characters;
        }

        /**
         *
         * @return
         * The stories
         */
        public Stories getStories() {
            return stories;
        }

        /**
         *
         * @param stories
         * The stories
         */
        public void setStories(Stories stories) {
            this.stories = stories;
        }

        /**
         *
         * @return
         * The comics
         */
        public Comics getComics() {
            return comics;
        }

        /**
         *
         * @param comics
         * The comics
         */
        public void setComics(Comics comics) {
            this.comics = comics;
        }

        /**
         *
         * @return
         * The events
         */
        public Events getEvents() {
            return events;
        }

        /**
         *
         * @param events
         * The events
         */
        public void setEvents(Events events) {
            this.events = events;
        }

        /**
         *
         * @return
         * The next
         */
        public Object getNext() {
            return next;
        }

        /**
         *
         * @param next
         * The next
         */
        public void setNext(Object next) {
            this.next = next;
        }

        /**
         *
         * @return
         * The previous
         */
        public Object getPrevious() {
            return previous;
        }

        /**
         *
         * @param previous
         * The previous
         */
        public void setPrevious(Object previous) {
            this.previous = previous;
        }



    }


    public class Thumbnail {

        private String path;
        private String extension;

        /**
         *
         * @return
         * The path
         */
        public String getPath() {
            return path;
        }

        /**
         *
         * @param path
         * The path
         */
        public void setPath(String path) {
            this.path = path;
        }

        /**
         *
         * @return
         * The extension
         */
        public String getExtension() {
            return extension;
        }

        /**
         *
         * @param extension
         * The extension
         */
        public void setExtension(String extension) {
            this.extension = extension;
        }


    }

    public class Url {

        private String type;
        private String url;

        /**
         *
         * @return
         * The type
         */
        public String getType() {
            return type;
        }

        /**
         *
         * @param type
         * The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }


    }
}
