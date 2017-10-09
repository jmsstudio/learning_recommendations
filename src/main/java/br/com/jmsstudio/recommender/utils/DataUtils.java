package br.com.jmsstudio.recommender.utils;

import br.com.jmsstudio.recommender.ProductsRecommender;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;

public class DataUtils {

    public static DataModel createDataModelFromFile(String path) throws IOException {
        ClassLoader classLoader = ProductsRecommender.class.getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        return new FileDataModel(file);
    }
}
