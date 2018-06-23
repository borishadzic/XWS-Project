using AdminFront.DTOs;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Security;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace AdminFront.Requests
{
    public class ClientRequests
    {
        private static string webApi = "https://localhost:8443/";
        public static string token = "";

        
        public static List<AdminCommentDTO> getComments()
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/getComments");
            request.Method = "GET";
            request.UseDefaultCredentials = true; request.Headers.Add("Authorization", "Bearer " + token);



            var response = (HttpWebResponse)request.GetResponse();
            using (var streamReader = new StreamReader(response.GetResponseStream()))
            {
                var result = streamReader.ReadToEnd();
                var klijenti = JsonConvert.DeserializeObject<List<AdminCommentDTO>>(result);
                streamReader.Close();
                return klijenti;
            }


        }

        public static void ApproveComment(AdminCommentDTO comment)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/approveComments");
            
            request.Method = "POST";
            request.ContentType = "application/json";
            request.UseDefaultCredentials = true;
            request.Headers.Add("Authorization", "Bearer " + token);

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                string content2 = JsonConvert.SerializeObject(comment);
                streamWriter.Write(content2);
                streamWriter.Flush();
                streamWriter.Close();
            }


            var response = (HttpWebResponse)request.GetResponse();

        }

        public static void BanComment(AdminCommentDTO comment)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/banComments");

            request.Method = "POST";
            request.ContentType = "application/json";
            request.UseDefaultCredentials = true;
            request.Headers.Add("Authorization", "Bearer " + token);

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                string content2 = JsonConvert.SerializeObject(comment);
                streamWriter.Write(content2);
                streamWriter.Flush();
                streamWriter.Close();
            }


            var response = (HttpWebResponse)request.GetResponse();

        }
        
        public static ProfileDTO toogleLockedUser(ProfileDTO user)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/changeLockStatusFalse");

            ProfileDTO user1 = user;

            request.Method = "POST";
            request.ContentType = "application/json";
            request.UseDefaultCredentials = true;
            request.Headers.Add("Authorization", "Bearer " + token);

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                string content2 = JsonConvert.SerializeObject(user);
                streamWriter.Write(content2);
                streamWriter.Flush();
                streamWriter.Close();
            }



            var response = (HttpWebResponse)request.GetResponse();


            using (var streamReader = new StreamReader(response.GetResponseStream()))
            {
                var result = streamReader.ReadToEnd();
                var klijent = JsonConvert.DeserializeObject<ProfileDTO>(result);
                streamReader.Close();
                return klijent;
            }

        }


        public static void addType(string type)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/addType");

            request.Method = "POST";
            request.ContentType = "application/json";
            request.UseDefaultCredentials = true;
            request.Headers.Add("Authorization", "Bearer " + token);

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                string content2 = JsonConvert.SerializeObject(new AdditionalServicesDTO(type,0));
                streamWriter.Write(content2);
                streamWriter.Flush();
                streamWriter.Close();
            }



            var response = (HttpWebResponse)request.GetResponse();
            
        }

        public static void addService(string type)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/addService");

            request.Method = "POST";
            request.ContentType = "application/json";
            request.UseDefaultCredentials = true;
            request.Headers.Add("Authorization", "Bearer " + token);

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                string content2 = JsonConvert.SerializeObject(new AdditionalServicesDTO(type,0));
                streamWriter.Write(content2);
                streamWriter.Flush();
                streamWriter.Close();
            }



            var response = (HttpWebResponse)request.GetResponse();
            

        }

        public static void addCatagory(string type)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/addCategory");

            request.Method = "POST";
            request.ContentType = "application/json";
            request.UseDefaultCredentials = true;
            request.Headers.Add("Authorization", "Bearer " + token);

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                string content2 = JsonConvert.SerializeObject(new AdditionalServicesDTO(type,0));
                streamWriter.Write(content2);
                streamWriter.Flush();
                streamWriter.Close();
            }



            var response = (HttpWebResponse)request.GetResponse();

            
        }

        public static ProfileDTO toogleLockedUser2(ProfileDTO user)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/changeLockStatusTrue");

            ProfileDTO user1 = user;

            request.Method = "POST";
            request.ContentType = "application/json";
            request.UseDefaultCredentials = true;
            request.Headers.Add("Authorization", "Bearer " + token);

            using (var streamWriter = new StreamWriter(request.GetRequestStream()))
            {
                string content2 = JsonConvert.SerializeObject(user);
                streamWriter.Write(content2);
                streamWriter.Flush();
                streamWriter.Close();
            }



            var response = (HttpWebResponse)request.GetResponse();


            using (var streamReader = new StreamReader(response.GetResponseStream()))
            {
                var result = streamReader.ReadToEnd();
                var klijent = JsonConvert.DeserializeObject<ProfileDTO>(result);
                streamReader.Close();
                return klijent;
            }

        }

        public static FilterDTO getFilters()
        {
            ServicePointManager.ServerCertificateValidationCallback =
                delegate (object s, X509Certificate certificate,
               X509Chain chain, SslPolicyErrors sslPolicyErrors)
                { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi + "api/filter");
            request.Method = "GET";
            request.UseDefaultCredentials = true; request.Headers.Add("Authorization", "Bearer " + token);

            var response = (HttpWebResponse)request.GetResponse();
            using (var streamReader = new StreamReader(response.GetResponseStream()))
            {
                var result = streamReader.ReadToEnd();
                var filter = JsonConvert.DeserializeObject<FilterDTO>(result);
                streamReader.Close();
                return filter;
            }



        }

        public static LoginToken SignIn(string username, string password1)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };
            try
            {
                
                var request = (HttpWebRequest)WebRequest.Create(webApi+"api/account/signin");
                
                request.Method = "POST";
                request.ContentType = "application/json";
                request.UseDefaultCredentials = true; request.Headers.Add("Authorization", "Bearer " + token);


                using (var streamWriter = new StreamWriter(request.GetRequestStream()))
                {
                    string content2 = JsonConvert.SerializeObject(new LoginDTO(username, password1));
                    streamWriter.Write(content2);
                    streamWriter.Flush();
                    streamWriter.Close();
                }
                 
                var response = (HttpWebResponse)request.GetResponse();
                using (var streamReader = new StreamReader(response.GetResponseStream()))
                {
                    var result = streamReader.ReadToEnd();
                    var rootObject = JsonConvert.DeserializeObject<LoginToken>(result);
                    token = rootObject.accessToken;
                    streamReader.Close();
                    
                    return rootObject;
                }


            } catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }
        }

        public static ModifyDTO modifyType(string oldName, string newName)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            try
            {

                var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/modifyType");

                request.Method = "POST";
                request.ContentType = "application/json";
                request.UseDefaultCredentials = true; request.Headers.Add("Authorization", "Bearer " + token);


                using (var streamWriter = new StreamWriter(request.GetRequestStream()))
                {
                    string content2 = JsonConvert.SerializeObject(new ModifyDTO(oldName, newName));
                    streamWriter.Write(content2);
                    streamWriter.Flush();
                    streamWriter.Close();
                }

                var response = (HttpWebResponse)request.GetResponse();
                using (var streamReader = new StreamReader(response.GetResponseStream()))
                {
                    var result = streamReader.ReadToEnd();
                    var rootObject = JsonConvert.DeserializeObject<ModifyDTO>(result);
                    streamReader.Close();

                    return rootObject;
                }


            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }


        }


        public static ModifyDTO modifyCategory(string oldName, string newName)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            try
            {

                var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/modifyCategory");

                request.Method = "POST";
                request.ContentType = "application/json";
                request.UseDefaultCredentials = true; request.Headers.Add("Authorization", "Bearer " + token);


                using (var streamWriter = new StreamWriter(request.GetRequestStream()))
                {
                    string content2 = JsonConvert.SerializeObject(new ModifyDTO(oldName, newName));
                    streamWriter.Write(content2);
                    streamWriter.Flush();
                    streamWriter.Close();
                }

                var response = (HttpWebResponse)request.GetResponse();
                using (var streamReader = new StreamReader(response.GetResponseStream()))
                {
                    var result = streamReader.ReadToEnd();
                    var rootObject = JsonConvert.DeserializeObject<ModifyDTO>(result);
                    streamReader.Close();

                    return rootObject;
                }


            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }


        }

        public static ModifyDTO modifyService(string oldName, string newName)
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            try
            {

                var request = (HttpWebRequest)WebRequest.Create(webApi + "api/admin/modifyService");

                request.Method = "POST";
                request.ContentType = "application/json";
                request.UseDefaultCredentials = true; request.Headers.Add("Authorization", "Bearer " + token);


                using (var streamWriter = new StreamWriter(request.GetRequestStream()))
                {
                    string content2 = JsonConvert.SerializeObject(new ModifyDTO(oldName, newName));
                    streamWriter.Write(content2);
                    streamWriter.Flush();
                    streamWriter.Close();
                }

                var response = (HttpWebResponse)request.GetResponse();
                using (var streamReader = new StreamReader(response.GetResponseStream()))
                {
                    var result = streamReader.ReadToEnd();
                    var rootObject = JsonConvert.DeserializeObject<ModifyDTO>(result);
                    streamReader.Close();

                    return rootObject;
                }


            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
                return null;
            }


        }



        public static List<ProfileDTO> getClients()
        {
            ServicePointManager.ServerCertificateValidationCallback =
                 delegate (object s, X509Certificate certificate,
                X509Chain chain, SslPolicyErrors sslPolicyErrors)
                 { return true; };

            var request = (HttpWebRequest)WebRequest.Create(webApi+"api/admin/getClients");

            request.Method = "GET";
            request.UseDefaultCredentials = true; request.Headers.Add("Authorization", "Bearer " + token);

            

            var response = (HttpWebResponse)request.GetResponse();
            using (var streamReader = new StreamReader(response.GetResponseStream()))
            {
                var result = streamReader.ReadToEnd();
                var klijenti = JsonConvert.DeserializeObject<List<ProfileDTO>>(result);
                streamReader.Close();
                return klijenti;
            }
            
        }



       



    }
}
