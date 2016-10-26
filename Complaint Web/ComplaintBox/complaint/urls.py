from django.conf.urls import url

from . import views

urlpatterns = [
	url(r'^$', views.validate,name='validate'),
	url(r'^validate1/$', views.validate1,name='validate1'),
	url(r'^validate2/$', views.validate2,name='validate2'),
] 