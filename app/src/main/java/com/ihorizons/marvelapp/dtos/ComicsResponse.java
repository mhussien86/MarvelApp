package com.ihorizons.marvelapp.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohamed on 01/10/16.
 */
public class ComicsResponse extends DetailsResponse implements Serializable {

        private Integer code;
        private String status;
        private String copyright;
        private String attributionText;
        private String attributionHTML;
        private String etag;
        private Data data;

        /**
         * @return The code
         */
        public Integer getCode() {
            return code;
        }

        /**
         * @param code The code
         */
        public void setCode(Integer code) {
            this.code = code;
        }

        /**
         * @return The status
         */
        public String getStatus() {
            return status;
        }

        /**
         * @param status The status
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         * @return The copyright
         */
        public String getCopyright() {
            return copyright;
        }

        /**
         * @param copyright The copyright
         */
        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        /**
         * @return The attributionText
         */
        public String getAttributionText() {
            return attributionText;
        }

        /**
         * @param attributionText The attributionText
         */
        public void setAttributionText(String attributionText) {
            this.attributionText = attributionText;
        }

        /**
         * @return The attributionHTML
         */
        public String getAttributionHTML() {
            return attributionHTML;
        }

        /**
         * @param attributionHTML The attributionHTML
         */
        public void setAttributionHTML(String attributionHTML) {
            this.attributionHTML = attributionHTML;
        }

        /**
         * @return The etag
         */
        public String getEtag() {
            return etag;
        }

        /**
         * @param etag The etag
         */
        public void setEtag(String etag) {
            this.etag = etag;
        }

        /**
         * @return The data
         */
        public Data getData() {
            return data;
        }

        /**
         * @param data The data
         */
        public void setData(Data data) {
            this.data = data;
        }




        public class Characters implements Serializable{

            private Integer available;
            private String collectionURI;
            private List<Item_> items = new ArrayList<Item_>();
            private Integer returned;

            /**
             * @return The available
             */
            public Integer getAvailable() {
                return available;
            }

            /**
             * @param available The available
             */
            public void setAvailable(Integer available) {
                this.available = available;
            }

            /**
             * @return The collectionURI
             */
            public String getCollectionURI() {
                return collectionURI;
            }

            /**
             * @param collectionURI The collectionURI
             */
            public void setCollectionURI(String collectionURI) {
                this.collectionURI = collectionURI;
            }

            /**
             * @return The items
             */
            public List<Item_> getItems() {
                return items;
            }

            /**
             * @param items The items
             */
            public void setItems(List<Item_> items) {
                this.items = items;
            }

            /**
             * @return The returned
             */
            public Integer getReturned() {
                return returned;
            }

            /**
             * @param returned The returned
             */
            public void setReturned(Integer returned) {
                this.returned = returned;
            }



        }



        public class Creators implements Serializable{

            private Integer available;
            private String collectionURI;
            private List<Item> items = new ArrayList<Item>();
            private Integer returned;

            /**
             * @return The available
             */
            public Integer getAvailable() {
                return available;
            }

            /**
             * @param available The available
             */
            public void setAvailable(Integer available) {
                this.available = available;
            }

            /**
             * @return The collectionURI
             */
            public String getCollectionURI() {
                return collectionURI;
            }

            /**
             * @param collectionURI The collectionURI
             */
            public void setCollectionURI(String collectionURI) {
                this.collectionURI = collectionURI;
            }

            /**
             * @return The items
             */
            public List<Item> getItems() {
                return items;
            }

            /**
             * @param items The items
             */
            public void setItems(List<Item> items) {
                this.items = items;
            }

            /**
             * @return The returned
             */
            public Integer getReturned() {
                return returned;
            }

            /**
             * @param returned The returned
             */
            public void setReturned(Integer returned) {
                this.returned = returned;
            }



        }

        public class Data implements Serializable{

            private Integer offset;
            private Integer limit;
            private Integer total;
            private Integer count;
            private List<Result> results = new ArrayList<Result>();

            /**
             * @return The offset
             */
            public Integer getOffset() {
                return offset;
            }

            /**
             * @param offset The offset
             */
            public void setOffset(Integer offset) {
                this.offset = offset;
            }

            /**
             * @return The limit
             */
            public Integer getLimit() {
                return limit;
            }

            /**
             * @param limit The limit
             */
            public void setLimit(Integer limit) {
                this.limit = limit;
            }

            /**
             * @return The total
             */
            public Integer getTotal() {
                return total;
            }

            /**
             * @param total The total
             */
            public void setTotal(Integer total) {
                this.total = total;
            }

            /**
             * @return The count
             */
            public Integer getCount() {
                return count;
            }

            /**
             * @param count The count
             */
            public void setCount(Integer count) {
                this.count = count;
            }

            /**
             * @return The results
             */
            public List<Result> getResults() {
                return results;
            }

            /**
             * @param results The results
             */
            public void setResults(List<Result> results) {
                this.results = results;
            }



        }

        public class Date  implements Serializable{

            private String type;
            private String date;

            /**
             * @return The type
             */
            public String getType() {
                return type;
            }

            /**
             * @param type The type
             */
            public void setType(String type) {
                this.type = type;
            }

            /**
             * @return The date
             */
            public String getDate() {
                return date;
            }

            /**
             * @param date The date
             */
            public void setDate(String date) {
                this.date = date;
            }



        }

        public class Events  implements Serializable {

            private Integer available;
            private String collectionURI;
            private List<Item___> items = new ArrayList<Item___>();
            private Integer returned;

            /**
             * @return The available
             */
            public Integer getAvailable() {
                return available;
            }

            /**
             * @param available The available
             */
            public void setAvailable(Integer available) {
                this.available = available;
            }

            /**
             * @return The collectionURI
             */
            public String getCollectionURI() {
                return collectionURI;
            }

            /**
             * @param collectionURI The collectionURI
             */
            public void setCollectionURI(String collectionURI) {
                this.collectionURI = collectionURI;
            }

            /**
             * @return The items
             */
            public List<Item___> getItems() {
                return items;
            }

            /**
             * @param items The items
             */
            public void setItems(List<Item___> items) {
                this.items = items;
            }

            /**
             * @return The returned
             */
            public Integer getReturned() {
                return returned;
            }

            /**
             * @param returned The returned
             */
            public void setReturned(Integer returned) {
                this.returned = returned;
            }

        }

        public class Image implements Serializable{

            private String path;
            private String extension;

            /**
             * @return The path
             */
            public String getPath() {
                return path;
            }

            /**
             * @param path The path
             */
            public void setPath(String path) {
                this.path = path;
            }

            /**
             * @return The extension
             */
            public String getExtension() {
                return extension;
            }

            /**
             * @param extension The extension
             */
            public void setExtension(String extension) {
                this.extension = extension;
            }


        }


        public class Item  implements Serializable{

            private String resourceURI;
            private String name;
            private String role;

            /**
             * @return The resourceURI
             */
            public String getResourceURI() {
                return resourceURI;
            }

            /**
             * @param resourceURI The resourceURI
             */
            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            /**
             * @return The name
             */
            public String getName() {
                return name;
            }

            /**
             * @param name The name
             */
            public void setName(String name) {
                this.name = name;
            }

            /**
             * @return The role
             */
            public String getRole() {
                return role;
            }

            /**
             * @param role The role
             */
            public void setRole(String role) {
                this.role = role;
            }



        }

        public class Item_  implements Serializable{

            private String resourceURI;
            private String name;

            /**
             * @return The resourceURI
             */
            public String getResourceURI() {
                return resourceURI;
            }

            /**
             * @param resourceURI The resourceURI
             */
            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            /**
             * @return The name
             */
            public String getName() {
                return name;
            }

            /**
             * @param name The name
             */
            public void setName(String name) {
                this.name = name;
            }


        }

        public class Item__  implements Serializable{

            private String resourceURI;
            private String name;
            private String type;

            /**
             * @return The resourceURI
             */
            public String getResourceURI() {
                return resourceURI;
            }

            /**
             * @param resourceURI The resourceURI
             */
            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            /**
             * @return The name
             */
            public String getName() {
                return name;
            }

            /**
             * @param name The name
             */
            public void setName(String name) {
                this.name = name;
            }

            /**
             * @return The type
             */
            public String getType() {
                return type;
            }

            /**
             * @param type The type
             */
            public void setType(String type) {
                this.type = type;
            }

        }


        public class Item___  implements Serializable{

            private String resourceURI;
            private String name;

            /**
             * @return The resourceURI
             */
            public String getResourceURI() {
                return resourceURI;
            }

            /**
             * @param resourceURI The resourceURI
             */
            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            /**
             * @return The name
             */
            public String getName() {
                return name;
            }

            /**
             * @param name The name
             */
            public void setName(String name) {
                this.name = name;
            }


        }

        public class Price  implements Serializable{

            private String type;
            private Double price;

            /**
             * @return The type
             */
            public String getType() {
                return type;
            }

            /**
             * @param type The type
             */
            public void setType(String type) {
                this.type = type;
            }

            /**
             * @return The price
             */
            public Double getPrice() {
                return price;
            }

            /**
             * @param price The price
             */
            public void setPrice(Double price) {
                this.price = price;
            }



        }

        public class Result implements Serializable{

            private Integer id;
            private Integer digitalId;
            private String title;
            private Integer issueNumber;
            private String variantDescription;
            private String description;
            private String modified;
            private String isbn;
            private String upc;
            private String diamondCode;
            private String ean;
            private String issn;
            private String format;
            private Integer pageCount;
            private List<TextObject> textObjects = new ArrayList<TextObject>();
            private String resourceURI;
            private List<Url> urls = new ArrayList<Url>();
            private Series series;
            private List<Variant> variants = new ArrayList<Variant>();
            private List<Object> collections = new ArrayList<Object>();
            private List<Object> collectedIssues = new ArrayList<Object>();
            private List<Date> dates = new ArrayList<Date>();
            private List<Price> prices = new ArrayList<Price>();
            private Thumbnail thumbnail;
            private List<Image> images = new ArrayList<Image>();
            private Creators creators;
            private Characters characters;
            private Stories stories;
            private Events events;

            /**
             * @return The id
             */
            public Integer getId() {
                return id;
            }

            /**
             * @param id The id
             */
            public void setId(Integer id) {
                this.id = id;
            }

            /**
             * @return The digitalId
             */
            public Integer getDigitalId() {
                return digitalId;
            }

            /**
             * @param digitalId The digitalId
             */
            public void setDigitalId(Integer digitalId) {
                this.digitalId = digitalId;
            }

            /**
             * @return The title
             */
            public String getTitle() {
                return title;
            }

            /**
             * @param title The title
             */
            public void setTitle(String title) {
                this.title = title;
            }

            /**
             * @return The issueNumber
             */
            public Integer getIssueNumber() {
                return issueNumber;
            }

            /**
             * @param issueNumber The issueNumber
             */
            public void setIssueNumber(Integer issueNumber) {
                this.issueNumber = issueNumber;
            }

            /**
             * @return The variantDescription
             */
            public String getVariantDescription() {
                return variantDescription;
            }

            /**
             * @param variantDescription The variantDescription
             */
            public void setVariantDescription(String variantDescription) {
                this.variantDescription = variantDescription;
            }

            /**
             * @return The description
             */
            public String getDescription() {
                return description;
            }

            /**
             * @param description The description
             */
            public void setDescription(String description) {
                this.description = description;
            }

            /**
             * @return The modified
             */
            public String getModified() {
                return modified;
            }

            /**
             * @param modified The modified
             */
            public void setModified(String modified) {
                this.modified = modified;
            }

            /**
             * @return The isbn
             */
            public String getIsbn() {
                return isbn;
            }

            /**
             * @param isbn The isbn
             */
            public void setIsbn(String isbn) {
                this.isbn = isbn;
            }

            /**
             * @return The upc
             */
            public String getUpc() {
                return upc;
            }

            /**
             * @param upc The upc
             */
            public void setUpc(String upc) {
                this.upc = upc;
            }

            /**
             * @return The diamondCode
             */
            public String getDiamondCode() {
                return diamondCode;
            }

            /**
             * @param diamondCode The diamondCode
             */
            public void setDiamondCode(String diamondCode) {
                this.diamondCode = diamondCode;
            }

            /**
             * @return The ean
             */
            public String getEan() {
                return ean;
            }

            /**
             * @param ean The ean
             */
            public void setEan(String ean) {
                this.ean = ean;
            }

            /**
             * @return The issn
             */
            public String getIssn() {
                return issn;
            }

            /**
             * @param issn The issn
             */
            public void setIssn(String issn) {
                this.issn = issn;
            }

            /**
             * @return The format
             */
            public String getFormat() {
                return format;
            }

            /**
             * @param format The format
             */
            public void setFormat(String format) {
                this.format = format;
            }

            /**
             * @return The pageCount
             */
            public Integer getPageCount() {
                return pageCount;
            }

            /**
             * @param pageCount The pageCount
             */
            public void setPageCount(Integer pageCount) {
                this.pageCount = pageCount;
            }

            /**
             * @return The textObjects
             */
            public List<TextObject> getTextObjects() {
                return textObjects;
            }

            /**
             * @param textObjects The textObjects
             */
            public void setTextObjects(List<TextObject> textObjects) {
                this.textObjects = textObjects;
            }

            /**
             * @return The resourceURI
             */
            public String getResourceURI() {
                return resourceURI;
            }

            /**
             * @param resourceURI The resourceURI
             */
            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            /**
             * @return The urls
             */
            public List<Url> getUrls() {
                return urls;
            }

            /**
             * @param urls The urls
             */
            public void setUrls(List<Url> urls) {
                this.urls = urls;
            }

            /**
             * @return The series
             */
            public Series getSeries() {
                return series;
            }

            /**
             * @param series The series
             */
            public void setSeries(Series series) {
                this.series = series;
            }

            /**
             * @return The variants
             */
            public List<Variant> getVariants() {
                return variants;
            }

            /**
             * @param variants The variants
             */
            public void setVariants(List<Variant> variants) {
                this.variants = variants;
            }

            /**
             * @return The collections
             */
            public List<Object> getCollections() {
                return collections;
            }

            /**
             * @param collections The collections
             */
            public void setCollections(List<Object> collections) {
                this.collections = collections;
            }

            /**
             * @return The collectedIssues
             */
            public List<Object> getCollectedIssues() {
                return collectedIssues;
            }

            /**
             * @param collectedIssues The collectedIssues
             */
            public void setCollectedIssues(List<Object> collectedIssues) {
                this.collectedIssues = collectedIssues;
            }

            /**
             * @return The dates
             */
            public List<Date> getDates() {
                return dates;
            }

            /**
             * @param dates The dates
             */
            public void setDates(List<Date> dates) {
                this.dates = dates;
            }

            /**
             * @return The prices
             */
            public List<Price> getPrices() {
                return prices;
            }

            /**
             * @param prices The prices
             */
            public void setPrices(List<Price> prices) {
                this.prices = prices;
            }

            /**
             * @return The thumbnail
             */
            public Thumbnail getThumbnail() {
                return thumbnail;
            }

            /**
             * @param thumbnail The thumbnail
             */
            public void setThumbnail(Thumbnail thumbnail) {
                this.thumbnail = thumbnail;
            }

            /**
             * @return The images
             */
            public List<Image> getImages() {
                return images;
            }

            /**
             * @param images The images
             */
            public void setImages(List<Image> images) {
                this.images = images;
            }

            /**
             * @return The creators
             */
            public Creators getCreators() {
                return creators;
            }

            /**
             * @param creators The creators
             */
            public void setCreators(Creators creators) {
                this.creators = creators;
            }

            /**
             * @return The characters
             */
            public Characters getCharacters() {
                return characters;
            }

            /**
             * @param characters The characters
             */
            public void setCharacters(Characters characters) {
                this.characters = characters;
            }

            /**
             * @return The stories
             */
            public Stories getStories() {
                return stories;
            }

            /**
             * @param stories The stories
             */
            public void setStories(Stories stories) {
                this.stories = stories;
            }

            /**
             * @return The events
             */
            public Events getEvents() {
                return events;
            }

            /**
             * @param events The events
             */
            public void setEvents(Events events) {
                this.events = events;
            }


        }

        public class Series  implements Serializable{

            private String resourceURI;
            private String name;

            /**
             * @return The resourceURI
             */
            public String getResourceURI() {
                return resourceURI;
            }

            /**
             * @param resourceURI The resourceURI
             */
            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            /**
             * @return The name
             */
            public String getName() {
                return name;
            }

            /**
             * @param name The name
             */
            public void setName(String name) {
                this.name = name;
            }


        }

        public class Stories  implements Serializable{

            private Integer available;
            private String collectionURI;
            private List<Item__> items = new ArrayList<Item__>();
            private Integer returned;

            /**
             * @return The available
             */
            public Integer getAvailable() {
                return available;
            }

            /**
             * @param available The available
             */
            public void setAvailable(Integer available) {
                this.available = available;
            }

            /**
             * @return The collectionURI
             */
            public String getCollectionURI() {
                return collectionURI;
            }

            /**
             * @param collectionURI The collectionURI
             */
            public void setCollectionURI(String collectionURI) {
                this.collectionURI = collectionURI;
            }

            /**
             * @return The items
             */
            public List<Item__> getItems() {
                return items;
            }

            /**
             * @param items The items
             */
            public void setItems(List<Item__> items) {
                this.items = items;
            }

            /**
             * @return The returned
             */
            public Integer getReturned() {
                return returned;
            }

            /**
             * @param returned The returned
             */
            public void setReturned(Integer returned) {
                this.returned = returned;
            }

        }

        public class TextObject implements Serializable{

            private String type;
            private String language;
            private String text;

            /**
             * @return The type
             */
            public String getType() {
                return type;
            }

            /**
             * @param type The type
             */
            public void setType(String type) {
                this.type = type;
            }

            /**
             * @return The language
             */
            public String getLanguage() {
                return language;
            }

            /**
             * @param language The language
             */
            public void setLanguage(String language) {
                this.language = language;
            }

            /**
             * @return The text
             */
            public String getText() {
                return text;
            }

            /**
             * @param text The text
             */
            public void setText(String text) {
                this.text = text;
            }



        }

        public class Thumbnail  implements Serializable {

            private String path;
            private String extension;

            /**
             * @return The path
             */
            public String getPath() {
                return path;
            }

            /**
             * @param path The path
             */
            public void setPath(String path) {
                this.path = path;
            }

            /**
             * @return The extension
             */
            public String getExtension() {
                return extension;
            }

            /**
             * @param extension The extension
             */
            public void setExtension(String extension) {
                this.extension = extension;
            }



        }

        public class Url  implements Serializable{

            private String type;
            private String url;

            /**
             * @return The type
             */
            public String getType() {
                return type;
            }

            /**
             * @param type The type
             */
            public void setType(String type) {
                this.type = type;
            }

            /**
             * @return The url
             */
            public String getUrl() {
                return url;
            }

            /**
             * @param url The url
             */
            public void setUrl(String url) {
                this.url = url;
            }


        }


        public class Variant  implements Serializable{

            private String resourceURI;
            private String name;

            /**
             * @return The resourceURI
             */
            public String getResourceURI() {
                return resourceURI;
            }

            /**
             * @param resourceURI The resourceURI
             */
            public void setResourceURI(String resourceURI) {
                this.resourceURI = resourceURI;
            }

            /**
             * @return The name
             */
            public String getName() {
                return name;
            }

            /**
             * @param name The name
             */
            public void setName(String name) {
                this.name = name;
            }



        }


    }
