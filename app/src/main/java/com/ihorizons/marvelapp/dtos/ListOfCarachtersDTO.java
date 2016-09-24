package com.ihorizons.marvelapp.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed on 24/09/16.
 */
public class ListOfCarachtersDTO {


        private String code;

        private String status;

        private String copyright;

        private String attributionText;

        private String attributionHTML;

        private Data data;

        private String etag;

        /**
         *
         * @return
         * The code
         */
        public String getCode() {
            return code;
        }

        /**
         *
         * @param code
         * The code
         */
        public void setCode(String code) {
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


     public class Comics {


        private String available;

        private String returned;

        private String collectionURI;

        private List<Item> items = new ArrayList<Item>();

        /**
         *
         * @return
         * The available
         */
        public String getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(String available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The returned
         */
        public String getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(String returned) {
            this.returned = returned;
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

    }

    public class Data {


        private int offset;

        private int limit;

        private int total;

        private int count;

        private List<Result> results = new ArrayList<Result>();

        /**
         *
         * @return
         * The offset
         */
        public int getOffset() {
            return offset;
        }

        /**
         *
         * @param offset
         * The offset
         */
        public void setOffset(int offset) {
            this.offset = offset;
        }

        /**
         *
         * @return
         * The limit
         */
        public int getLimit() {
            return limit;
        }

        /**
         *
         * @param limit
         * The limit
         */
        public void setLimit(int limit) {
            this.limit = limit;
        }

        /**
         *
         * @return
         * The total
         */
        public int getTotal() {
            return total;
        }

        /**
         *
         * @param total
         * The total
         */
        public void setTotal(int total) {
            this.total = total;
        }

        /**
         *
         * @return
         * The count
         */
        public int getCount() {
            return count;
        }

        /**
         *
         * @param count
         * The count
         */
        public void setCount(int count) {
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

        private String available;

        private String returned;

        private String collectionURI;

        private List<Item__> items = new ArrayList<Item__>();

        /**
         *
         * @return
         * The available
         */
        public String getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(String available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The returned
         */
        public String getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(String returned) {
            this.returned = returned;
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

    }

    public class Item {

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

    public class Item_ {

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

    public class Item__ {


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


        private String id;

        private String name;

        private String description;

        private String modified;

        private String resourceURI;

        private List<Url> urls = new ArrayList<Url>();

        private Thumbnail thumbnail;

        private Comics comics;

        private Stories stories;

        private Events events;

        private Series series;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
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
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
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
         * The series
         */
        public Series getSeries() {
            return series;
        }

        /**
         *
         * @param series
         * The series
         */
        public void setSeries(Series series) {
            this.series = series;
        }

    }

    public class Series {


        private String available;

        private String returned;

        private String collectionURI;

        private List<Item___> items = new ArrayList<Item___>();

        /**
         *
         * @return
         * The available
         */
        public String getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(String available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The returned
         */
        public String getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(String returned) {
            this.returned = returned;
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

    }

    public class Stories {

        private String available;

        private String returned;

        private String collectionURI;

        private List<Item_> items = new ArrayList<Item_>();

        /**
         *
         * @return
         * The available
         */
        public String getAvailable() {
            return available;
        }

        /**
         *
         * @param available
         * The available
         */
        public void setAvailable(String available) {
            this.available = available;
        }

        /**
         *
         * @return
         * The returned
         */
        public String getReturned() {
            return returned;
        }

        /**
         *
         * @param returned
         * The returned
         */
        public void setReturned(String returned) {
            this.returned = returned;
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

