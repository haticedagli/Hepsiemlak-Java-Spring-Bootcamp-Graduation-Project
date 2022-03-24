package com.hepsiemlak.advertservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;

@RequiredArgsConstructor
@Slf4j
@Component
@Service
public class ElasticSearchOperationsRepository {

    public final RestHighLevelClient client;

    public boolean checkIndexExist(String indexName) {
        try {
            return client.indices().exists(new GetIndexRequest(indexName.toLowerCase()), RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public void createIndex(String index, CreateIndexRequest createIndexRequest) {
        try {
            client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void executeBulk(BulkRequest bulkRequest) {
        try {
            if(!CollectionUtils.isEmpty(bulkRequest.requests()))
                client.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public SearchResponse search(SearchRequest searchRequest) {
        SearchResponse searchResponse = null;
        try {
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return searchResponse;
    }

    public MultiSearchResponse multiSearch(MultiSearchRequest multiSearchRequest) {
        MultiSearchResponse multiSearchResponse = null;
        try {
            multiSearchResponse = client.msearch(multiSearchRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return multiSearchResponse;
    }

    public void delete(DeleteByQueryRequest deleteByQueryRequest) throws Exception {
        client.deleteByQuery(deleteByQueryRequest, RequestOptions.DEFAULT);
    }

}
