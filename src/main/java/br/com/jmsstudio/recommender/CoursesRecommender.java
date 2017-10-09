package br.com.jmsstudio.recommender;

import br.com.jmsstudio.recommender.builder.CustomRecommenderBuilder;
import br.com.jmsstudio.recommender.utils.DataUtils;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.IOException;
import java.util.List;

public class CoursesRecommender {

    public static void main(String[] args) throws IOException, TasteException {
        DataModel model = DataUtils.createDataModelFromFile("courses.csv");
        Recommender recommender = new CustomRecommenderBuilder().buildRecommender(model);

        List<RecommendedItem> recommendations = recommender.recommend(2, 3);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }

    }
}
