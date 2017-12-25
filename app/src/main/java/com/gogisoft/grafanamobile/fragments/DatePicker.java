package com.gogisoft.grafanamobile.fragments;

import android.R.bool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appeaser.sublimepickerlibrary.R;
import com.appeaser.sublimepickerlibrary.SublimePicker;
import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate;
import com.appeaser.sublimepickerlibrary.helpers.SublimeListenerAdapter;
import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions;
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class DatePicker extends DialogFragment {
    public interface Callback {
        void onDateSet(Calendar start, Calendar end);
    }

    Callback callback;

    Calendar startDate, endDate;

    SublimeListenerAdapter mListener = new SublimeListenerAdapter() {
        @Override
        public void onCancelled() {
            dismiss();
        }

        @Override
        public void onDateTimeRecurrenceSet(SublimePicker sublimeMaterialPicker,
                                            SelectedDate selectedDate,
                                            int hourOfDay, int minute,
                                            SublimeRecurrencePicker.RecurrenceOption recurrenceOption,
                                            String recurrenceRule) {
            if (callback != null) {
                callback.onDateSet(selectedDate.getFirstDate(), selectedDate.getEndDate());
            }

            dismiss();
        }
    };

    public DatePicker(Calendar start, Calendar end, Callback callback) {
        this.startDate = start;
        this.endDate = end;
        this.callback = callback;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        SublimePicker mSublimePicker = (SublimePicker) (inflater.inflate(R.layout.sublime_picker, container));

        SublimeOptions options = new SublimeOptions();
        options.setDisplayOptions(
            SublimeOptions.ACTIVATE_DATE_PICKER |
            SublimeOptions.ACTIVATE_TIME_PICKER);
        options.setCanPickDateRange(true);
        options.setDateParams(startDate, endDate);

        mSublimePicker.initializePicker(options, mListener);

        return mSublimePicker;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
