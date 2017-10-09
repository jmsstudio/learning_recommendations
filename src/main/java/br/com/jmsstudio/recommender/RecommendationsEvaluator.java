package br.com.jmsstudio.recommender;

import br.com.jmsstudio.recommender.builder.CustomRecommenderBuilder;
import br.com.jmsstudio.recommender.utils.DataUtils;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.common.RandomUtils;

import java.io.IOException;

public class RecommendationsEvaluator {

    public static void main(String[] args) throws IOException, TasteException {
        RandomUtils.useTestSeed();

        System.out.println("=== Evaluating users data ===");
        DataModel model = DataUtils.createDataModelFromFile("data.csv");
        evaluateRecommender(model);

        System.out.println("\n");
        System.out.println("=== Evaluating courses data ===");
        model = DataUtils.createDataModelFromFile("courses.csv");
        evaluateRecommender(model);
    }

    private static void evaluateRecommender(DataModel model) throws TasteException {
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        double errorRate = evaluator.evaluate(new CustomRecommenderBuilder(), null, model, 0.9, 1.0);

        System.out.println("Error rate: " + errorRate);
    }
}
