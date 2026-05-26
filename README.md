# Bean & Bliss - Envanter Yönetim Sistemi

Bu proje, bir kahve evi ve pastane zincirinin stok, müşteri, sipariş ve finansal işlemlerini yönetmek için geliştirilmiş kurumsal bir Spring Boot uygulamasıdır.

## Kullanılan Teknolojiler
- **Java 17+**
- **Spring Boot** (Web, Security, Data JPA)
- **PostgreSQL** (Veritabanı)
- **Bootstrap 5 & FontAwesome** (Arayüz)
- **Maven** (Bağımlılık Yönetimi)

## Özellikler
- 📦 Envanter yönetimi (ürün ekleme, düzenleme, silme, tedarikçi atama)
- 🚚 Tedarikçi yönetimi (yetkili kişi, e-posta, telefon, adres)
- 👥 Müşteri portföyü (telefon numarası desteği)
- 🧾 Sipariş merkezi (adisyon fişleri, sayfa yenilemede kalıcı)
- 💳 Finansal tahsilat akışı (kasa geçmişi)

## Mimari
Proje, katmanlı mimari yapısına uygun olarak düzenlenmiştir:
- `entity`: Veritabanı tabloları.
- `repository`: Veri erişim katmanı (Derived Query Methods).
- `service`: İş mantığı katmanı.
- `controller`: API uç noktaları.
- `dto`: Veri transfer objeleri.
- `exception`: Merkezi hata yönetimi.

## Kurulum
1. Projeyi klonlayın: `git clone https://github.com/aleynaa52/stok-yonetim.git`
2. `application.properties` dosyasında veritabanı ayarlarınızı güncelleyin.
3. Projeyi IntelliJ IDEA ile açın ve Maven bağımlılıklarının yüklenmesini bekleyin.
4. Uygulamayı `StokYonetimApplication` sınıfından çalıştırın.
5. `http://localhost:8082` üzerinden sisteme erişin.