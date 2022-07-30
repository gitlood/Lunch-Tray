// Generated by data binding compiler. Do not edit!
package com.example.lunchtray.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.lunchtray.R;
import com.example.lunchtray.model.OrderViewModel;
import com.example.lunchtray.ui.order.AccompanimentMenuFragment;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentAccompanimentMenuBinding extends ViewDataBinding {
  @NonNull
  public final RadioGroup accompanimentOptions;

  @NonNull
  public final RadioButton berries;

  @NonNull
  public final TextView berriesDescription;

  @NonNull
  public final TextView berriesPrice;

  @NonNull
  public final RadioButton bread;

  @NonNull
  public final TextView breadDescription;

  @NonNull
  public final TextView breadPrice;

  @NonNull
  public final Button cancelButton;

  @NonNull
  public final View divider;

  @NonNull
  public final Button nextButton;

  @NonNull
  public final RadioButton pickles;

  @NonNull
  public final TextView picklesDescription;

  @NonNull
  public final TextView picklesPrice;

  @NonNull
  public final TextView subtotal;

  @Bindable
  protected OrderViewModel mViewModel;

  @Bindable
  protected AccompanimentMenuFragment mFragment;

  @Bindable
  protected String mBrea;

  @Bindable
  protected String mBerrie;

  @Bindable
  protected String mPickle;

  protected FragmentAccompanimentMenuBinding(Object _bindingComponent, View _root,
      int _localFieldCount, RadioGroup accompanimentOptions, RadioButton berries,
      TextView berriesDescription, TextView berriesPrice, RadioButton bread,
      TextView breadDescription, TextView breadPrice, Button cancelButton, View divider,
      Button nextButton, RadioButton pickles, TextView picklesDescription, TextView picklesPrice,
      TextView subtotal) {
    super(_bindingComponent, _root, _localFieldCount);
    this.accompanimentOptions = accompanimentOptions;
    this.berries = berries;
    this.berriesDescription = berriesDescription;
    this.berriesPrice = berriesPrice;
    this.bread = bread;
    this.breadDescription = breadDescription;
    this.breadPrice = breadPrice;
    this.cancelButton = cancelButton;
    this.divider = divider;
    this.nextButton = nextButton;
    this.pickles = pickles;
    this.picklesDescription = picklesDescription;
    this.picklesPrice = picklesPrice;
    this.subtotal = subtotal;
  }

  public abstract void setViewModel(@Nullable OrderViewModel viewModel);

  @Nullable
  public OrderViewModel getViewModel() {
    return mViewModel;
  }

  public abstract void setFragment(@Nullable AccompanimentMenuFragment fragment);

  @Nullable
  public AccompanimentMenuFragment getFragment() {
    return mFragment;
  }

  public abstract void setBrea(@Nullable String brea);

  @Nullable
  public String getBrea() {
    return mBrea;
  }

  public abstract void setBerrie(@Nullable String berrie);

  @Nullable
  public String getBerrie() {
    return mBerrie;
  }

  public abstract void setPickle(@Nullable String pickle);

  @Nullable
  public String getPickle() {
    return mPickle;
  }

  @NonNull
  public static FragmentAccompanimentMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_accompaniment_menu, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAccompanimentMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentAccompanimentMenuBinding>inflateInternal(inflater, R.layout.fragment_accompaniment_menu, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAccompanimentMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_accompaniment_menu, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentAccompanimentMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentAccompanimentMenuBinding>inflateInternal(inflater, R.layout.fragment_accompaniment_menu, null, false, component);
  }

  public static FragmentAccompanimentMenuBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentAccompanimentMenuBinding bind(@NonNull View view,
      @Nullable Object component) {
    return (FragmentAccompanimentMenuBinding)bind(component, view, R.layout.fragment_accompaniment_menu);
  }
}
