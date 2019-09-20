//package com.test1;
//
///**
// * @author czy
// * @date 2018/11/14 11:04
// */
//import com.google.gson.*;
//import com.google.gson.reflect.TypeToken;
//
//import java.lang.reflect.Type;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
///**
// * Created by zzm on 2017/8/25 10:46.
// */
//public class TestGson {
//    public static void main(String[] args) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("a", 10);
//        map.put("b", "10");
//        map.put("c", 10L);
//        map.put("d", "fsaf");
//        //Gson gson = new Gson();
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(
//                        new TypeToken<Map<String, Object>>() {
//                        }.getType(),
//                        new JsonDeserializer<Map<String, Object>>() {
//                            @Override
//                            public Map<String, Object> deserialize(
//                                    JsonElement json, Type typeOfT,
//                                    JsonDeserializationContext context) throws JsonParseException {
//
//                                Map<String, Object> treeMap = new HashMap<String, Object>();
//                                JsonObject jsonObject = json.getAsJsonObject();
//                                Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
//                                for (Map.Entry<String, JsonElement> entry : entrySet) {
//                                    treeMap.put(entry.getKey(), entry.getValue());
//                                }
//                                return treeMap;
//                            }
//                        }).create();
//
//        String json = gson.toJson(map);
//        System.out.println(json);
//
//        Map map1 = gson.fromJson(json, Map.class);
//        Map map2 = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
//        }.getType());
//
//        System.out.println(1);
//    }
//}
