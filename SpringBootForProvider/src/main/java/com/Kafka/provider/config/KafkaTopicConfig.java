package com.Kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;

import java.util.Map;

@Configurable
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){


        Map<String,String> configuration = new HashMap<>();
        //Primera config: delete (borra el mensaje), compact (Mantiene el mas actual)
        configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG,TopicConfig.CLEANUP_POLICY_DELETE);//Configuracion del tratamiento de borrado de mensajes

        //Segunda config: Tiempo de retencio de mensajes - (defecto -1 /No elimina los mensaje)
        configuration.put(TopicConfig.RETENTION_MS_CONFIG,"8640000"); //Cuanto va a ser el tiempo que el mensaje va estar en el servidor

        //Tercera config: Tamaño de los segmentos en los topic (Valores en bytes) / (defecto 1073741824 / 1GB)
        configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"/*1GB*/); // Indicar el tamaño maximo de los segmenos en el topic

        //Cuarto config: Configuracion de tamaño del mensaje / (defecto 1MB)
        configuration.put(TopicConfig.MAX_COMPACTION_LAG_MS_CONFIG,"1000012"); //Indica el tamaño maximo de cada mensaje


        return TopicBuilder.name("topicExample-Topic")
                .partitions(2) // Para crear particiones dentro del kluster
                .replicas(2) //Para crear copias del topic
                .configs(configuration)
                .build();
    }
}
