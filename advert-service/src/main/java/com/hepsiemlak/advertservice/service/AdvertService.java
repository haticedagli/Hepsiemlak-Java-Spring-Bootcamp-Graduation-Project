package com.hepsiemlak.advertservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hepsiemlak.advertservice.model.Advert;
import com.hepsiemlak.advertservice.repository.ElasticSearchOperationsRepository;
import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AdvertService {

    public final RestHighLevelClient client;
    private final ObjectMapper objectMapper;

    public String save(Advert advert) throws IOException {
        UUID uuid = UUID.randomUUID();
        advert.setId(uuid.toString());

        Map<String, Object> document = objectMapper.convertValue(advert, Map.class);

        IndexRequest indexRequest = new IndexRequest("advert", "_doc", uuid.toString())
                .source(document)
                .id(advert.getId())
                .routing(advert.getId());

        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

        return indexResponse
                .getResult()
                .name();
    }

    public Advert findById(String id) throws IOException {

        GetRequest getRequest = new GetRequest("advert", "_doc", id);

        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> resultMap = getResponse.getSource();

        return objectMapper
                .convertValue(resultMap, Advert.class);
    }

    public List<Advert> findAll() throws Exception {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("advert");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse =
                client.search(searchRequest, RequestOptions.DEFAULT);

        return getSearchResult(searchResponse);
    }

    private List<Advert> getSearchResult(SearchResponse response) {

        SearchHit[] searchHit = response.getHits().getHits();

        List<Advert> adverts = new ArrayList<>();

        if (searchHit.length > 0) {

            Arrays.stream(searchHit)
                    .forEach(hit -> adverts
                            .add(objectMapper
                                    .convertValue(hit.getSourceAsMap(),
                                            Advert.class))
                    );
        }

        return adverts;
    }
}
