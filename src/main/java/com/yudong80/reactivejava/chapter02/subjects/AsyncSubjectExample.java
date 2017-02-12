package com.yudong80.reactivejava.chapter02.subjects;

import com.yudong80.reactivejava.common.CommonUtils;

import io.reactivex.Observable;
import io.reactivex.subjects.AsyncSubject;

public class AsyncSubjectExample {
	public void basic() { 
		AsyncSubject<String> subject = AsyncSubject.create();
		subject.subscribe(str -> System.out.println("Observer #1 => "+ str));
		subject.onNext("Red");
		subject.onNext("Green");
		subject.subscribe(str -> System.out.println("Observer #2 => "+ str));
		subject.onNext("Blue");
		subject.onComplete();
		CommonUtils.exampleComplete();
	}
	
	public void subscribeObservable() { 
		Float[] temperature = { 10.1f, 13.4f, 12.5f  };
		Observable<Float> source = Observable.fromArray(temperature);
		
		AsyncSubject<Float> subject = AsyncSubject.create();
		source.subscribe(subject);
		subject.subscribe(System.out::println);	
		CommonUtils.exampleComplete();		
	}
	
	public void multiSubscribed() { 
		AsyncSubject<Integer> subject = AsyncSubject.create();
		subject.onNext(10);
		subject.onNext(11);
		subject.subscribe(str -> System.out.println("#1 => " + str));
		subject.onNext(12);
		subject.onComplete();
		subject.subscribe(str -> System.out.println("#2 => " + str));
		CommonUtils.exampleComplete();		
	}
	
	public static void main(String[] args) { 
		AsyncSubjectExample demo = new AsyncSubjectExample();
		demo.basic(); 
		demo.subscribeObservable();
		demo.multiSubscribed();
	}
}
