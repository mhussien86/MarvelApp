package com.ihorizons.marvelapp.dtos;

/**
 * Created by mohamed on 01/10/16.
 */
public class DetailsResponse {

    private ComicsResponse comicsResponse ;
    private EventsResponse eventsResponse ;
    private SeriesResponse seriesResponse ;
    private StoriesResponse storiesResponse ;
    public ComicsResponse getComicsResponse() {
        return comicsResponse;
    }

    public void setComicsResponse(ComicsResponse comicsResponse) {
        this.comicsResponse = comicsResponse;
    }

    public EventsResponse getEventsResponse() {
        return eventsResponse;
    }

    public void setEventsResponse(EventsResponse eventsResponse) {
        this.eventsResponse = eventsResponse;
    }

    public SeriesResponse getSeriesResponse() {
        return seriesResponse;
    }

    public void setSeriesResponse(SeriesResponse seriesResponse) {
        this.seriesResponse = seriesResponse;
    }

    public StoriesResponse getStoriesResponse() {
        return storiesResponse;
    }

    public void setStoriesResponse(StoriesResponse storiesResponse) {
        this.storiesResponse = storiesResponse;
    }


}
