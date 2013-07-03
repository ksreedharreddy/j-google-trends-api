package org.freaknet.gtrends.api.gtrendsapi;

import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author Marco Tizzoni <marco.tizzoni@gmail.com>
 */
public class GoogleTrendsRequest {
    /* Google Trends Service URL */
    private static final String SERVICE_URL = "http://www.google.com/trends/viz";

    /* Google Trends parameters */
    private static final String P_LANGUAGE = "hl";
    private static final String P_QUERY = "q";
    private static final String P_EXPORT = "export";
    private static final String P_CMPT = "cmpt";
    private static final String P_CONTENT = "content";
    private static final String P_DATE = "date";
    private static final String P_GEO = "geo";
    private static final String P_GEOR = "geor";
    private static final String P_GRAPH = "graph";
    private static final String P_SORT = "sort";
    private static final String P_SCALE = "scale";
    private static final String P_SA = "sa";

    /* Google Trends defaults */
    private String language = "en-US";
    private String date = "all";
    private String geo = "all";
    private String geor = "all";
    private String graph = "all_csv";
    private int sort = 0;
    private int scale = 0;
    private String sa = "N";
    private int export = 1;
    private String cmpt = "q";
    private int content = 1;
    private String query;

    public GoogleTrendsRequest(String q) {
        this.query = q;
    }

    public HttpRequestBase build(String q) {
        setQuery(q);
        return build();
    }

    public HttpRequestBase build() {
        HttpRequestBase request = null;
        try {
            URIBuilder b = new URIBuilder(SERVICE_URL);
            b.setParameter(P_LANGUAGE, getLanguage())
                    .setParameter(P_QUERY, getQuery())
                    .setParameter(P_EXPORT, String.valueOf(export))
                    .setParameter(P_CMPT, cmpt)
                    .setParameter(P_CONTENT, String.valueOf(content))
                    .setParameter(P_DATE, getDate())
                    .setParameter(P_GEO, getGeo())
                    .setParameter(P_GEOR, getGeor())
                    .setParameter(P_GRAPH, getGraph())
                    .setParameter(P_SORT, String.valueOf(getSort()))
                    .setParameter(P_SCALE, String.valueOf(getScale()))
                    .setParameter(P_SA, getSa());

            request = new HttpGet(b.build());
            GoogleUtils.setupHttpRequestDefaults(request);
        } catch (URISyntaxException ex) {
            Logger.getLogger(GoogleTrendsRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

        return request;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the geo
     */
    public String getGeo() {
        return geo;
    }

    /**
     * @param geo the geo to set
     */
    public void setGeo(String geo) {
        this.geo = geo;
    }

    /**
     * @return the geor
     */
    public String getGeor() {
        return geor;
    }

    /**
     * @param geor the geor to set
     */
    public void setGeor(String geor) {
        this.geor = geor;
    }

    /**
     * @return the graph
     */
    public String getGraph() {
        return graph;
    }

    /**
     * @param graph the graph to set
     */
    public void setGraph(String graph) {
        this.graph = graph;
    }

    /**
     * @return the sort
     */
    public int getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(int sort) {
        this.sort = sort;
    }

    /**
     * @return the scale
     */
    public int getScale() {
        return scale;
    }

    /**
     * @param scale the scale to set
     */
    public void setScale(int scale) {
        this.scale = scale;
    }

    /**
     * @return the sa
     */
    public String getSa() {
        return sa;
    }

    /**
     * @param sa the sa to set
     */
    public void setSa(String sa) {
        this.sa = sa;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }
}