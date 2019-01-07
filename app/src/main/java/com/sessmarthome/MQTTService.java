package com.sessmarthome;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MQTTService extends Service {

    MqttHelper mqttHelper;

    public MQTTService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startMqtt();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void startMqtt(){
        mqttHelper = new MqttHelper(getApplicationContext());
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean b, String s) {

            }

            @Override
            public void connectionLost(Throwable throwable) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
//                tvTemp.setText("");
//                tvMotion.setText("");
//                tvHumidity.setText("");
//                Log.e("MQTT", mqttMessage.toString());
//                String message = mqttMessage.toString();
//                String[] arr = message.split(",");
//                tvTemp.setText(arr[0]);
//                tvHumidity.setText(arr[1]);
//                tvMotion.setText(arr[2]);
//                String tempVal = arr[0].split("=")[1];
//                lineChartHelper.addEntry(Float.valueOf(tempVal.trim()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

            }
        });
    }

}
