# Thử thách “1 Prompt”

Thử thách này kiểm tra xem một prompt duy nhất có thể giúp khởi tạo thành công một project kiểm thử đăng nhập đơn giản bằng **Java, Selenium 4, Cucumber, JUnit 5 và Maven** hay không.

## Kết quả

Project được tạo theo cấu trúc Maven chuẩn, áp dụng Page Object Model và có scenario Cucumber kiểm thử đăng nhập thành công trên [SauceDemo](https://www.saucedemo.com). Thông tin URL và tài khoản thử nghiệm nằm trong file cấu hình riêng; Selenium Manager tự tìm browser driver. Các bước chờ trang và phần tử sử dụng explicit wait.

Chạy kiểm thử ở chế độ No headless sẽ thấy browser mở lên:

```bash
mvn test
```
Hoặc chạy ở chế độ headless:

```bash
mvn test -Dheadless=true
```

## The perfect "1 Prompt":

Đây là prompt đã dùng để khởi tạo project:

> Hãy setup hoàn chỉnh project Java Selenium + Cucumber để test đăng nhập tại https://www.saucedemo.com, theo Maven và Page Object Model chuẩn.
>
> Yêu cầu:
>
> - Dùng Java 17+, Selenium, Cucumber và JUnit 5 với các phiên bản tương thích.
> - Tạo cấu trúc Maven chuẩn, Cucumber runner, hooks quản lý WebDriver, Page Object, step definitions và feature đăng nhập thành công.
> - Lưu base URL, `standard_user` và `secret_sauce` trong file config; không hardcode trong step hoặc Page Object.
> - Dùng Selenium Manager để tự tìm browser driver.
> - Dùng **explicit wait** (`WebDriverWait`/`ExpectedConditions`) để chờ form hiển thị sau khi mở trang, chờ các trường nhập liệu và nút login sẵn sàng, rồi chờ trang sản phẩm sau khi đăng nhập. Không dựa vào `implicit wait` hoặc `Thread.sleep()`.
> - Viết assertion xác nhận đăng nhập thành công trên trang sản phẩm.
> - Chạy `mvn test -Dheadless=true`. Nếu test lỗi, hãy đọc log, xác định nguyên nhân, sửa code và chạy lại cho đến khi test pass; không báo thành công nếu chưa chạy được.

## Prompt Version 2:

Có thêm 3 yếu tố: Tích hợp Allure report, Data-driven testing (login với nhiều user) và tích hợp CI/CD GitHub Actions

```
Hãy setup hoàn chỉnh project Java Selenium + Cucumber để test đăng nhập tại https://www.saucedemo.com, theo Maven và Page Object Model chuẩn.

Yêu cầu:

- Dùng Java 17+, Selenium, Cucumber và JUnit 5 với các phiên bản tương thích.
- Tạo cấu trúc Maven chuẩn, Cucumber runner, hooks quản lý WebDriver, Page Object, step definitions và feature đăng nhập thành công.
- Dùng Selenium Manager để tự tìm browser driver.
- Dùng **explicit wait** (`WebDriverWait`/`ExpectedConditions`) để chờ form hiển thị sau khi mở trang, chờ các trường nhập liệu và nút login sẵn sàng, rồi chờ trang sản phẩm sau khi đăng nhập. Không dựa vào `implicit wait` hoặc `Thread.sleep()`.
- Tích hợp Allure Report tương thích với Cucumber và JUnit Platform. Ghi kết quả test vào Allure results, cấu hình cách tạo report và ghi rõ các lệnh để chạy test và xem report.
- Chuyển kiểm thử đăng nhập sang data-driven testing bằng Cucumber `Scenario Outline` và `Examples` hoặc một cách tương đương phù hợp. Chạy lần lượt với các username `standard_user`, `locked_out_user`, `problem_user`, `performance_glitch_user`, `error_user`, `visual_user`; mật khẩu dùng chung cho tất cả là `secret_sauce`.
- Lưu base URL, danh sách username và mật khẩu dùng chung trong file cấu hình; không hardcode URL hay thông tin đăng nhập trong step definitions hoặc Page Objects.
- Assertion phải phản ánh đúng kết quả của từng user: `locked_out_user` phải bị từ chối và hiển thị thông báo lỗi phù hợp; các user còn lại phải đăng nhập thành công và thấy trang Products.
- Tích hợp GitHub Actions để chạy `mvn test -Dheadless=true` khi có pull request và khi push lên nhánh chính. Dùng Java 17, lưu lại Allure results/report thành artifact để có thể tải từ workflow run, và cấu hình workflow theo hướng bảo trì được.
- Chạy test tại local bằng `mvn test -Dheadless=true`, kiểm tra kết quả và report. Nếu có lỗi, hãy đọc log, xác định nguyên nhân, sửa rồi chạy lại đến khi pass; không báo thành công nếu chưa chạy được. Cuối cùng liệt kê các file đã tạo hoặc chỉnh sửa và cách xem Allure report.
```