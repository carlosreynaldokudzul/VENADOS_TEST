package com.venadostest.utiles;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonFactory {
    @NonNull
    private static Gson Instance = new Gson();

    @NonNull
    public static Gson getInstance() {
        return Instance;
    }

    public static Gson getCustomizedDateInstance() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new DateDeserializer());
        builder.serializeNulls();
        return builder.create();
    }

    public static Gson getStandardDateInstance() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new StandardDate());
        builder.serializeNulls();
        return builder.create();
    }

    public static Gson getInstanceWithNulls() {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        return builder.create();
    }
}

class StandardDate implements JsonSerializer<Date> {
    @NonNull
    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return new JsonPrimitive(dateFormat.format(src));
    }
}

class DateDeserializer implements JsonDeserializer<Date>, JsonSerializer<Date> {

    private final Pattern Regex = Pattern.compile("/Date\\((\\d+)([-+])(\\d+)\\)/");

    @Nullable
    @Override
    public Date deserialize(@NonNull JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        Date response = null;
        String date = element.getAsString();
        Matcher groups = Regex.matcher(date);
        if (groups.find()) {
            long millis = Long.parseLong(groups.group(1));
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis);
            response = calendar.getTime();
        }

        return response;
    }

    @NonNull
    @Override
    public JsonElement serialize(@NonNull Date src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive("/Date(" + src.getTime() + "-0600)/");
    }
}