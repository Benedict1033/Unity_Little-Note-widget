package com.DefaultCompany.LittleNote20211210;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RemoteViews;

import java.io.File;

/**
 * Implementation of App Widget functionality.
 */
public class Nefinal extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        ComponentName thisWidget = new ComponentName(context, Nefinal.class);
        int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

        for (int widgetId : allWidgetIds) {

            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.nefinal)000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000;

            Intent intent = new Intent(context, Nefinal.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            int a = 0;
            File files = new File("sdcard/DCIM/LittleNote/");

            String file[] = files.list();
            for (String x : file) {

                if (x.endsWith(".png"))
                    a++;
            }
            String filePath = "sdcard/DCIM/LittleNote/" + a + ".png";
            Bitmap bitmap = BitmapFactory.decodeFile(filePath);
            views.setImageViewBitmap(R.id.imageView, bitmap);
            views.setTextViewText(R.id.appwidget_text, "" + a);

            views.setOnClickPendingIntent(R.id.imageView, pendingIntent);

            appWidgetManager.updateAppWidget(widgetId, views);
        }

    }
}
