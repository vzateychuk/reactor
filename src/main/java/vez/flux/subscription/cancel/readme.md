# Cancel Subscription

Если запустить этот код, он выведет в консоль следующие строки:
onNext: 1
onNext: 2
onNext: 3
onNext: 4
Обратите внимание, что мы не получили сигнал onComplete, потому что подписчик отменил подписку до завершения потока данных. 
Также важно помнить, что реактивный поток может быть завершен производителем (с сигналом onError или onComplete) или 
подписчиком через экземпляр Subscription. Кроме того, для отмены подписки можно использовать экземпляр Disposable. 


